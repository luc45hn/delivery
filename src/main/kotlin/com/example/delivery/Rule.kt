package com.example.delivery

data class Rule(val id: String, val name: String, val product: String, val validity: Validity, val teamMembers: List<String>)

data class Validity(val start: String, val end: String)

data class RuleList(val rules: List<Rule>)
