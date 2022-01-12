package com.company.app.constants;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class ConsoleConstants {

    public static final List<String> MANUAL = ImmutableList.<String>builder()
            .add("Валидации нет. За корректность вводимых данных отвечает пользователь.")
            .add("Пример создания новой записи: create Vladimir 1may")
            .add("Пример чтения всех записей: read")
            .add("Пример обвновления существующей записи: update Vladimir 1may to Vladimir 1febr")
            .add("Пример удаления существующей записи: delete Vladimir 1febr")
            .build();
}
