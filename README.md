# Руководство по использованию "Character Frequency Calculator"

## Описание проекта

Проект "Character Frequency Calculator" представляет собой RESTful веб-приложение, которое вычисляет частоту встречи символов в заданной строке. Результат возвращается в формате JSON и отсортирован по убыванию количества вхождений символов в строку.

## Основные функции

- Вычисление частоты встречи символов в заданной строке.
- Сортировка результатов по убыванию количества вхождений символов.
- Обработка ошибок, таких как некорректная строка ввода или пустая строка.

## Использование API

### 1. Вычисление частоты символов

**URL:** `/calculate-frequency`

**Метод:** GET

**Параметры запроса:**
- `input` (обязательный) - Строка, для которой нужно вычислить частоту символов.

**Пример запроса:**

```
GET /calculate-frequency?input=aaaaabcccc
```

**Пример ответа:**
```json
[
    {"character": "a", "frequency": 5},
    {"character": "c", "frequency": 4},
    {"character": "b", "frequency": 1}
]
```

### 2. Обработка ошибок

В случае возникновения ошибки, API возвращает HTTP-статус 400 Bad Request и соответствующее сообщение об ошибке.

**Пример запроса с ошибкой:**

```
GET /calculate-frequency?input=123abc
```

**Пример ответа с ошибкой:**

{
    "error": "Входная строка должна содержать только буквы."
}

## Запуск приложения

Для запуска приложения выполните следующие шаги:

1. Убедитесь, что у вас установлен Maven и JDK.
2. Склонируйте проект из репозитория.
3. В командной строке перейдите в каталог проекта.
4. Выполните команду `mvn clean install` для сборки проекта.
5. После успешной сборки, запустите приложение с помощью команды `mvn spring-boot:run`.
6. Приложение будет доступно по адресу http://localhost:8080.



