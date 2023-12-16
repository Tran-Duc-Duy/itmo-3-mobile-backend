package com.itmo.kotlinspringbootjwtbase.repository

import com.itmo.kotlinspringbootjwtbase.model.Role
import com.itmo.kotlinspringbootjwtbase.model.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepository {
    private  val users = mutableListOf(
        User(
            id=UUID.randomUUID(),
            email = "tranduy-01@gmail.com",
            password = "123456Duy!",
            role= Role.USER
        ),
        User(
            id=UUID.randomUUID(),
            email = "tranduy-02@gmail.com",
            password = "123456Duy?",
            role= Role.USER
        ),
        User(
            id=UUID.randomUUID(),
            email = "tranduy-03@gmail.com",
            password = "123456Duy.",
            role= Role.USER
        ),
    )
    fun save(user:User): Boolean= users.add(user)
    fun findByEmail(email:String) :User? = users.firstOrNull { it.email == email }
    fun findByUUID(uuid:UUID) :User? = users.firstOrNull { it.id == uuid }
    fun findAll():List<User> = users
    fun deleteByUUID(uuid:UUID):Boolean {
        val foundUser = findByUUID(uuid)
        return foundUser?.let { users.remove(it) }?:false
    }
}