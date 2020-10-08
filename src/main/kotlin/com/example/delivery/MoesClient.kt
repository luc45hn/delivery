package com.example.delivery

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class MoesClient {

    @Autowired
    lateinit var restTemplate: RestTemplate
    val url1: String = "http://localhost:8080/blocking-rule?id=1"
    val url2: String = "http://localhost:8080/blocking-rule?id=2"
    val url3: String = "http://localhost:8080/blocking-rule?id=3"

    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    fun getRules(): List<Rule?> {
        logger.info("request URL===========:{}", url1)
        val rule1 = restTemplate.getForObject(url1, Rule::class.java)
        logger.info("request URL===========:{}", url2)
        val rule2 = restTemplate.getForObject(url2, Rule::class.java)
        logger.info("request URL===========:{}", url3)
        val rule3 = restTemplate.getForObject(url3, Rule::class.java)

        return mutableListOf(rule1, rule2, rule3)

    }
}