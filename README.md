### Установка и запуск

Для запуска приложения нужно происать команду 
>docker compose up

Приложение будет доступно по локальному адрессу на 8080 порту.

### API

#### Добавление события
POST запрос по адрессу /users с обязательными параметрами event (название события) и is_auth (статус пользователя, true или false)

#### Получение статистики

GET запрос по адресу /users c необязательными параметрами event (фильтрация по названию события) и date (фильтрация по дате события), и обязательным параметром by со значением events, status или ip (соответствует необходимой группировке).
##### Формат ответа
###### Аггрегирование по ip

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

###### Аггрегирование по названию

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
        "ip",
        "number"
      ]
    }
  ]
}
```


###### Аггрегирование по статусу авторизации

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
        "ip",
        "number"
      ]
    }
  ]
}
```


