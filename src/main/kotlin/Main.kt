package ru.netology

fun agoToText(secondsAgo: Long, name: String): String {
    return when {
        secondsAgo in 0..60 -> "$name был(а) только что"
        secondsAgo in 61..(60 * 60) -> "$name был(а) ${getMinuteForm(secondsAgo / 60)} назад"
        secondsAgo in (60 * 60 + 1)..(24 * 60 * 60) -> "$name был(а) ${getHourForm(secondsAgo / (60 * 60))} назад"
        secondsAgo in (24 * 60 * 60)..(2 * 24 * 60 * 60) -> "$name был(а) вчера"
        secondsAgo in (2 * 24 * 60 * 60)..(3 * 24 * 60 * 60) -> "$name был(а) позавчера"
        else -> "$name был(а) давно"
    }
}

fun getMinuteForm(minutes: Long): String {
    return when (minutes % 10) {
        1L -> "${minutes} минуту"
        2L, 3L, 4L -> "${minutes} минуты"
        5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L, 13L, 14L -> "${minutes} минут"
        else -> "${minutes} минут"
    }
}

fun getHourForm(hours: Long): String {
    return when (hours % 10) {
        1L, 21L -> "${hours} час"
        2L, 3L, 4L, 22L, 23L, 24L -> "${hours} часа"
        else -> "${hours} часов"
    }
}

fun main() {
    println(agoToText(0, "Паша")) // был(а) только что
    println(agoToText(30, "Маша")) // был(а) только что
    println(agoToText(61, "Гриша")) // был(а) 1 минуту назад
    println(agoToText(120, "Полина")) // был(а) 2 минуты назад
    println(agoToText(3600, "Даша")) // был(а) 1 час назад
    println(agoToText(7200, "Леша")) // был(а) 2 часа назад
    println(agoToText(86400,"Марина")) // был(а) вчера
    println(agoToText(172800,"Щавель")) // был(а) позавчера
    println(agoToText(259200, "Помидорина")) // был(а) давно
}
