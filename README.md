# Overview
REPO for java labs Variant 6
# Лабораторная работа №1  
## Часть 1
  1. Спроектировать базу данных для своего варианта задания. Таблицы БД должны быть во 2 нормальной форме. Для работы с БД рекомендуется использовать СУБД      MySQL.  
  2. Организовать соединение с базой данных: создать Java-класс, реализующий работу с connection (JdbcConnector).  
  3. При организации доступа к БД использовать шаблон Data Access Object. Создать DAO классы для выполнения запросов на извлечение информации из БД              (использовать PreparedStatement) и добавление информации. Подготовленные SQL запросы хранить в виде констант в соответствующем DAO классе.  
  4. Использовать файл ресурсов database.properties, в котором хранить параметры доступа к БД.  

  Взаимодействие пользователя с приложением организовать в консольном виде.

## Часть 2
1. Создать класс (ConnectionPool), реализующий пул соединений, хранящихся в коллекции и предоставляемых повторно.  
   Обеспечить потокобезопасность пула. Заменить класс JdbcConnector на ConnectionPool.  
2. Продумать обработку исключений, выбрасываемых в пуле и классах DAO. 

  Конструкторское бюро. Заказчик представляет Техническое Задание (ТЗ), в котором перечислен перечень Работ с указанием квалификации и количества  
  требуемых специалистов. Администратор рассматривает ТЗ и оформляет Проект, назначая на него незанятых Работников требуемой квалификации, после  
  чего рассчитывается стоимость Проекта и Заказчику выставляется Счет из расчета заработной платы назначенных специалистов.  
  Вывести информацию обо всех заданиях указанного заказчика.  
  Вывести информацию о требуемых специалистах указанного задания.  
  Назначить в проект работников.  
  Вывести информацию о неоплаченных проектах.  

# Branches
main: all lab work so far

# Building
IntelliJ IDEA
