package org.homework20250209.query

import org.homework20250209.data.UserDatabase
import org.homework20250209.exception.UserNotFoundException
import org.homework20250209.util.Enum

class RemoveUserQuery(line: List<String>): Query {

    override val queryType: String = Enum.QUERY_REMOVE_USER.query
    override val date: String

    val userId: String

    init {
        userId = line[IDX_USERID]
        date = "${line[IDX_DATE]} ${line[IDX_TIME]}"
    }

    override fun execute() {
        try {
            val removedUser = UserDatabase.getInstance().removeUser(userId)
            println("${removedUser.username} removed.")
        } catch (e: UserNotFoundException) {
            println("$userId not found.")
        }
    }

    companion object {
        const val IDX_DATE = 1
        const val IDX_TIME = 2
        const val IDX_USERID = 3
    }
}