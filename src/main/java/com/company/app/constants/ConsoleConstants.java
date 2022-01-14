package com.company.app.constants;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class ConsoleConstants {

	public static final List<String> MANUAL = ImmutableList.<String>builder()
			.add("Инструкция пользователя:")
			.add("Валидации нет. За корректность вводимых данных отвечает пользователь.")
			.add("Пример создания новой записи: create Vladimir 01.05")
			.add("Пример чтения всех записей: read")
			.add("Пример обвновления существующей записи: update Vladimir 01.05 to Vladimir 01.06")
			.add("Пример удаления существующей записи: delete Vladimir 01.06")
			.add("Вводите данные:")
			.build();
}
