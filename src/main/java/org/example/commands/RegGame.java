package org.example.commands;

import org.example.message.Answer;
import org.example.message.MessageType;
import org.example.model.EarningSetter;
import org.example.utility.DataBaseHandler;
import org.example.utility.Players;
import org.example.model.Earning;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Scanner;

public class RegGame extends AbstractCommand{
    private Double fullStake = 0.0;
    private DataBaseHandler dataBaseHandler = new DataBaseHandler();
    private Double allMoney;
    private LinkedHashMap<String, Double> peopleStakes = new LinkedHashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, EarningSetter> earningMap = new HashMap<>();

    public RegGame() {
        super("regGame", "Зарегистрировать выиграши игры");
        earningMap.put("Шика", Earning::setShikaEarning);
        earningMap.put("Кейт", Earning::setKateEarning);
        earningMap.put("Долгаша", Earning::setDolgashaEarning);
        earningMap.put("Бурмир", Earning::setBurmirEarning);
        earningMap.put("Едут", Earning::setEdutEarning);
        earningMap.put("Макс", Earning::setMaksEarning);
        earningMap.put("Макарыч", Earning::setMakarichEarning);
        earningMap.put("Паша", Earning::setPashaEarning);
        earningMap.put("Соня", Earning::setSonyaEarning);
    }

    @Override
    public MessageType execute() {
        Earning earning = new Earning();
        Integer countPeople = scanInt("Сколько людей заработало?\n>>");
        allMoney = scanDouble("Какой общий банк?\n>>");
        double stake;
        String name;
        for (int i = 0; i < countPeople; i++) {
            stake = scanDouble(STR."Какой стек у \{i + 1} игрока?\n>>");
            name = scanName();
            peopleStakes.put(name, stake);
            fullStake += stake;
        }
        peopleStakes.forEach( (nickname, playerStake) -> {
            double earnedPlayerMoney = (playerStake / fullStake) * allMoney;
            EarningSetter setter = earningMap.get(nickname);
            setter.setEarning(earning, earnedPlayerMoney);
        });
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        earning.setDate(currentDate.format(formatter));
        System.out.println(earning);
        System.out.print("Сохранить результаты в таблицу?\n>>");
        if (scanAnswer()) {
            dataBaseHandler.saveEarning(earning);
        }
        return MessageType.GOOD;
    }


    public String scanName() {
        String playerNameStr;
        Players playerName;
        while (true) {
            try {
                System.out.print("Какой у него\\нее имя?\n>>");
                playerNameStr = scanner.nextLine().trim();
                playerName = Players.valueOf(playerNameStr.toUpperCase(Locale.getDefault()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: такого игрока не существует!");
            }
        }
        return playerNameStr;
    }

    public boolean scanAnswer() {
        String answerStr;
        Answer answer;
        while (true) {
            try {
                answerStr = scanner.nextLine().trim();
                answer = Answer.valueOf(answerStr.toUpperCase(Locale.getDefault()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: можно отвечать только да или нет");
            }
        }
        return answer == Answer.ДА;
    }

    public Integer scanInt(String message) {
        int number;
        while (true) {
            try {
                System.out.print(message);
                number = Integer.parseInt(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Ввод должен быть числом!");
            }
        }
        return number;
    }

    public Double scanDouble(String message) {
        double number;
        while (true) {
            try {
                System.out.print(message);
                number = Double.parseDouble(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Ввод должен быть числом!");
            }
        }
        return number;
    }
}
