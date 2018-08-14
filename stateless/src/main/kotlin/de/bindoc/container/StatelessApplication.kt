package de.bindoc.container

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StatelessApplication


fun main(args: Array<String>) {
  runApplication<StatelessApplication>(*args)
}
