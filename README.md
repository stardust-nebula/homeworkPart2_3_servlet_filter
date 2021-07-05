# homeworkPart2_3_servlet_filter
В программе реализованы регистрация, авторизация, работа калькулятора, просмотр истории операций, логаут, смена парола, смена username, удаление аккаунта.
Применены фильтры к сервлетам: 
- AuthorizationFilter - авторизоваться можно, если еще не авторизован. 
- LogoutFilter - вылогиниться можно, если авторизован. 
- PasswordFilter - для регистрации и смены пароля. проверяет введенный пароль по заданному паттерну.
- UserChangeRequestFilter - изменить username или password можно если не авторизован. 
- UserFilter - только авторизованный пользователь может вызывать историю и калькулятор. 
- UsernameFilter - для регистрации и смены username. проверяет введенный username по заданному паттерну.
