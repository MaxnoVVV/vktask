### Установка и запуск

Для запуска приложения нужно прописать команду 
>docker compose up

Приложение будет доступно по локальному адресу на 8080 порту.

### API

#### Добавление события
POST запрос по адресу /users с обязательными параметрами event (название события) и is_auth (статус пользователя, true или false).

#### Получение статистики

GET запрос по адресу /users c необязательными параметрами event (фильтрация по названию события) и date (фильтрация по дате события), и обязательным параметром by со значением events, status или ip (соответствует необходимой группировке).
##### Формат ответа
###### Агрегирование по ip

```json
{
  "type": "array",
  "items": [
    {
      "type": "object",
      "properties": {
        "ip": {
          "type": "string"
        },
        "number": {
          "type": "integer"
        }
      },
      "required": [
        "ip",
        "number"
      ]
    }
  ]
}
```

###### Агрегирование по названию

```json
{
  "type": "array",
  "items": [
    {
      "type": "object",
      "properties": {
        "event": {
          "type": "string"
        },
        "number": {
          "type": "integer"
        }
      },
      "required": [
        "event",
        "number"
      ]
    }
  ]
}
```


###### Агрегирование по статусу авторизации

```json
{
  "type": "array",
  "items": [
    {
      "type": "object",
      "properties": {
        "is_auth": {
          "type": "boolean"
        },
        "number": {
          "type": "integer"
        }
      },
      "required": [
        "is_auth",
        "number"
      ]
    }
  ]
}
```


