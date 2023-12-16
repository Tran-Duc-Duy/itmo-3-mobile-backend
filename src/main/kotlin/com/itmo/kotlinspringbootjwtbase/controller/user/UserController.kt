package com.itmo.kotlinspringbootjwtbase.controller.user

import com.itmo.kotlinspringbootjwtbase.model.Role
import com.itmo.kotlinspringbootjwtbase.model.User
import com.itmo.kotlinspringbootjwtbase.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("api/user")
class UserController(
    private val userService: UserService
) {
    @PostMapping
    fun create(@RequestBody userRequest: UserRequest):UserResponse=
        userService.createUser(
            user= userRequest.toModel()
        )?.toResponse()?:throw ResponseStatusException(HttpStatus.BAD_REQUEST,"Khong tao duoc user")

    @GetMapping
    fun listAll():List <UserResponse> = userService.findAll().map { it.toResponse() }

    @GetMapping("/{uuid}")
    fun findByUUID (@PathVariable uuid: UUID):UserResponse = userService.findByUUID(uuid)?.toResponse()?:throw ResponseStatusException(HttpStatus.NOT_FOUND,"Meo thay ))")

    @DeleteMapping("/{uuid}")
    fun deleteByUUID (@PathVariable uuid: UUID):ResponseEntity<Boolean>{
        val success = userService.deleteByUUID(uuid)

        return if(success)
            ResponseEntity.noContent().build()
        else throw ResponseStatusException(HttpStatus.NOT_FOUND,"Xoa khong duoc ((")
    }


    private fun UserRequest.toModel(): User = User(
        id = UUID.randomUUID(),
        email = this.email,
        password = this.password,
        role= Role.USER
    )

    private fun User.toResponse():UserResponse= UserResponse(
        uuid = this.id,
        email=this.email
    )
}