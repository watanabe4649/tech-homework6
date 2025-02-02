package org.homework20250202.util

object UserUtil {
    fun createId(date: String): String {
        return date.apply {
            replace("-", "")
            replace(":", "")
            replace(" ", "")
        }
    }
}