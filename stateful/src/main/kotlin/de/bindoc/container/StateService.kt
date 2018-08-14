package de.bindoc.container

import org.springframework.stereotype.Service
import java.io.File

@Service
class StateService(
    configuration: StatefulApplicationConfiguration
) {
    val directory: File = File(configuration.directory)

    lateinit var state: State

    init {
        val file = File(directory, "state")
        if(file.exists()) {
            state = State.Persistent(file.lastModified())
        } else {
            state = State.NotPersistent()
            file.createNewFile()
        }
    }

}

