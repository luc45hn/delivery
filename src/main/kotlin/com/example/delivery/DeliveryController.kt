package com.example.delivery

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/delivery")
class DeliveryController {

    @Autowired
    lateinit var moesClient: MoesClient

    @GetMapping("/")
    fun findAll() = moesClient.getRules()

    @GetMapping("/blockTo/{to}")
    fun blockTo(@PathVariable to: String): List<Rule?> {
        val rules = moesClient.getRules()
        return rules.filter { rule -> rule?.teamMembers?.contains(to)!! }
    }
}