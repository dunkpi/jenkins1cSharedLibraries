package libs

// Управляет возможностью запуска РЗ в ИБ
//
// Параметры:
//  server1c - сервер 1c
//  port1c - порт сервера 1с
//  infobase - имя базы на сервере 1c и sql
//  user - имя админа 1С базы
//  passw - пароль админа 1С базы
//  action - lock/unlock - заблокировать/разблокировать РЗ
//  permCode - код блокирования ИБ
//
def lockIBTask(server1c, port1c, infobase, user, passw, action, permCode) {
    utils = new Utils()
    returnCode = utils.cmd("C:\\Windows\\SysWOW64\\WindowsPowerShell\\v1.0\\powershell.exe -ExecutionPolicy Bypass -file scripts/lock_ib.ps1 -server1c \"${server1c}\" -port1c \"${port1c}\" -infobase \"${infobase}\" -user \"${user}\" -passw \"${passw}\" -action \"${action}\" -permCode \"${permCode}\"")
    if (returnCode != 0) {
        utils.raiseError("Возникла ошибка при изменении возможности запуска РЗ для ${infobase} на ${action}")
    }
}

// Выбрасывает пользователей из ИБ
//
// Параметры:
//  server1c - сервер 1c
//  port1c - порт сервера 1с
//  infobase - имя базы на сервере 1c и sql
//  user - имя админа 1С базы
//  passw - пароль админа 1С базы
//
def kickUsers(server1c, port1c, infobase, user, passw) {
    utils = new Utils()
    returnCode = utils.cmd("C:\\Windows\\SysWOW64\\WindowsPowerShell\\v1.0\\powershell.exe -ExecutionPolicy Bypass -file scripts/kick_users.ps1 -server1c \"${server1c}\" -port1c \"${port1c}\" -infobase \"${infobase}\" -user \"${user}\" -passw \"${passw}\"")
    if (returnCode != 0) {
        utils.raiseError("Возникла ошибка при выбрасывании пользователей из  ${infobase}")
    }
}

// Создает бэкап конфигурации ИБ
//
// Параметры:
//  platform1c - версия платформы 1С, например 8.3.12.1529
//  server1c - сервер 1c
//  infobase - имя базы на сервере 1c и sql
//  user - имя админа 1С базы
//  passw - пароль админа 1С базы
//  backupDir - директория для сохранения бэкапа конфигурации
//  permCode - код блокирования ИБ
//
def backupConf(platform1c, server1c, infobase, user, passw, backupDir, permCode) {
    utils = new Utils()
    returnCode = utils.cmd("C:\\Windows\\SysWOW64\\WindowsPowerShell\\v1.0\\powershell.exe -ExecutionPolicy Bypass -file scripts/backup_conf.ps1 -platform1c \"${platform1c}\" -server1c \"${server1c}\" -infobase \"${infobase}\" -user \"${user}\" -passw \"${passw}\" -backupDir \"${backupDir}\" -permCode \"${permCode}\"")
    if (returnCode != 0) {
        utils.raiseError("Возникла ошибка при сохранении конфигурации базы ${infobase}")
    }
}

// Создает бэкап ИБ
//
// Параметры:
//  platform1c - версия платформы 1С, например 8.3.12.1529
//  server1c - сервер 1c
//  infobase - имя базы на сервере 1c и sql
//  user - имя админа 1С базы
//  passw - пароль админа 1С базы
//  backupDir - директория для сохранения бэкапа конфигурации
//  permCode - код блокирования ИБ
//
def backupIb(platform1c, server1c, infobase, user, passw, backupDir, permCode) {
    utils = new Utils()
    returnCode = utils.cmd("C:\\Windows\\SysWOW64\\WindowsPowerShell\\v1.0\\powershell.exe -ExecutionPolicy Bypass -file scripts/backup_ib.ps1 -platform1c \"${platform1c}\" -server1c \"${server1c}\" -infobase \"${infobase}\" -user \"${user}\" -passw \"${passw}\" -backupDir \"${backupDir}\" -permCode \"${permCode}\"")
    if (returnCode != 0) {
        utils.raiseError("Возникла ошибка при сохранении информационной базы ${infobase}")
    }
}

// Создает бэкап ИБ
//
// Параметры:
//  platform1c - версия платформы 1С, например 8.3.12.1529
//  backupDir - директория для сохранения бэкапа конфигурации
//  repServer1c - сервер 1с базы, подлключенной к хранилищу
//  repInfobase - база 1с, подключенная к хранилищу
//  repUser - пользователь базы 1с, подключенной к хранилищу
//  repPassw - пароль пользователя базы 1с, подключенной к хранилищу
//  repPath - адрес хранилища
//  repUser - пользователь хранилища
//  repPassw - пароль пользователя хранилища
//
def prepareUpdate(platform1c, repServer1c, repInfobase, repUser, repPassw, repPath, user, passw, backupDir, permCode) {
    utils = new Utils()
    returnCode = utils.cmd("C:\\Windows\\SysWOW64\\WindowsPowerShell\\v1.0\\powershell.exe -ExecutionPolicy Bypass -file scripts/prepare_update.ps1 -platform1c \"${platform1c}\" -repServer1c \"${repServer1c}\" -repInfobase \"${repInfobase}\" -repUser \"${repUser}\" -repPassw \"${repPassw}\" -repPath \"${repPath}\" -user \"${user}\" -passw \"${passw}\" -backupDir \"${backupDir}\" -permCode \"${permCode}\"")
    if (returnCode != 0) {
        utils.raiseError("Возникла ошибка при создании обновления ${infobase}")
    }
}

// Создает бэкап ИБ
//
// Параметры:
//  platform1c - версия платформы 1С, например 8.3.12.1529
//  server1c - сервер 1c
//  infobase - имя базы на сервере 1c и sql
//  user - имя админа 1С базы
//  passw - пароль админа 1С базы
//  backupDir - директория для сохранения бэкапа конфигурации
//  permCode - код блокирования ИБ
//
def update(platform1c, server1c, infobase, user, passw, backupDir, permCode) {
    utils = new Utils()
    returnCode = utils.cmd("C:\\Windows\\SysWOW64\\WindowsPowerShell\\v1.0\\powershell.exe -ExecutionPolicy Bypass -file scripts/update.ps1 -platform1c \"${platform1c}\" -server1c \"${server1c}\" -infobase \"${infobase}\" -user \"${user}\" -passw \"${passw}\" -backupDir \"${backupDir}\" -permCode \"${permCode}\"")
    if (returnCode != 0) {
        utils.raiseError("Возникла ошибка при обновлении информационной базы ${infobase}")
    }
}

// Запускает 1С Предприятие и открывает внешнюю обработку, которая закрывает 1С Предприятие
//
// Параметры:
//  platform1c - версия платформы 1С, например 8.3.12.1529
//  server1c - сервер 1c
//  infobase - имя базы на сервере 1c и sql
//  user - имя админа 1С базы
//  passw - пароль админа 1С базы
//
def start1c(platform1c,server1c, infobase, user, passw) {
    utils = new Utils()
    returnCode = utils.cmd("C:\\Windows\\SysWOW64\\WindowsPowerShell\\v1.0\\powershell.exe -ExecutionPolicy Bypass -file scripts/start_1c.ps1 -platform1c \"${platform1c}\" -server1c \"${server1c}\" -infobase \"${infobase}\" -user \"${user}\" -passw \"${passw}\"")
    if (returnCode != 0) {
        utils.raiseError("Возникла ошибка при запуске 1С Предприятия ${infobase}")
    }
}

// Запускает 1С Предприятие и открывает обработку выполняющую перепроведение
//
// Параметры:
//  platform1c - версия платформы 1С, например 8.3.12.1529
//  server1c - сервер 1c
//  infobase - имя базы на сервере 1c и sql
//  user - имя админа 1С базы
//  passw - пароль админа 1С базы
//  startDate - дата начала операции
//  endDate - дата окончания операции
//  backupDir - директория для сохранения логов операции
//
def repost8(platform1c, server1c, infobase, user, passw, startDate, endDate, backupDir) {
    utils = new Utils()
    returnCode = utils.cmd("C:\\Windows\\SysWOW64\\WindowsPowerShell\\v1.0\\powershell.exe -ExecutionPolicy Bypass -file scripts/repost8.ps1 -platform1c \"${platform1c}\" -server1c \"${server1c}\" -infobase \"${infobase}\" -user \"${user}\" -passw \"${passw}\" -startDate \"${startDate}\" -endDate \"${endDate}\" -backupDir \"${backupDir}\"")
    if (returnCode != 0) {
        utils.raiseError("Возникла ошибка при запуске 1С Предприятия ${infobase}")
    }
}

// Запускает 1С Предприятие и открывает обработку выполняющую сверку реестров и перенос в 1С 7
//
// Параметры:
//  platform1c - версия платформы 1С, например 8.3.12.1529
//  server1c - сервер 1c
//  infobase - имя базы на сервере 1c и sql
//  user - имя админа 1С базы
//  passw - пароль админа 1С базы
//  startDate - дата начала операции
//  endDate - дата окончания операции
//
def transfer(platform1c, server1c, infobase, user, passw, startDate, endDate) {
    utils = new Utils()
    returnCode = utils.cmd("C:\\Windows\\SysWOW64\\WindowsPowerShell\\v1.0\\powershell.exe -ExecutionPolicy Bypass -file scripts/transfer.ps1 -platform1c \"${platform1c}\" -server1c \"${server1c}\" -infobase \"${infobase}\" -user \"${user}\" -passw \"${passw}\" -startDate \"${startDate}\" -endDate \"${endDate}\"")
    if (returnCode != 0) {
        utils.raiseError("Возникла ошибка при запуске 1С Предприятия ${infobase}")
    }
}

// Запускает 1С Предприятие и открывает обработку выполняющую перенос в 1С 7 через обработку ИзмененныеДокументы
//
// Параметры:
//  platform1c - версия платформы 1С, например 8.3.12.1529
//  server1c - сервер 1c
//  infobase - имя базы на сервере 1c и sql
//  user - имя админа 1С базы
//  passw - пароль админа 1С базы
//  startDate - дата начала операции
//  endDate - дата окончания операции
//
def transferChangedDocs(platform1c, server1c, infobase, user, passw, startDate, endDate) {
    utils = new Utils()
    returnCode = utils.cmd("C:\\Windows\\SysWOW64\\WindowsPowerShell\\v1.0\\powershell.exe -ExecutionPolicy Bypass -file scripts/transferChangedDocs.ps1 -platform1c \"${platform1c}\" -server1c \"${server1c}\" -infobase \"${infobase}\" -user \"${user}\" -passw \"${passw}\" -startDate \"${startDate}\" -endDate \"${endDate}\"")
    if (returnCode != 0) {
        utils.raiseError("Возникла ошибка при запуске 1С Предприятия ${infobase}")
    }
}

// Запускает 1С Предприятие 7 и открывает обработку выполняющую перепроведение
//
// Параметры:
//  ibPath - Путь к базе 1С
//  user - имя админа 1С базы
//  passw - пароль админа 1С базы
//  startDate - дата начала операции
//  endDate - дата окончания операции
//  backupDir - директория для сохранения логов операции
//
def repost7(ibPath, user, passw, startDate, endDate, backupDir) {
    utils = new Utils()
    returnCode = utils.cmd("\"C:\\Program Files (x86)\\AutoIt3\\AutoIt3.exe\" \"scripts/repost7.au3\" \"${ibPath}\" \"${user}\" \"${passw}\" \"${startDate}\" \"${endDate}\" \"${backupDir}\"")
    if (returnCode != 0) {
        utils.raiseError("Возникла ошибка при запуске 1С Предприятия 7 ${ibPath}")
    }
}