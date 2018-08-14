package de.bindoc.container

import java.time.Instant

sealed class State(val isPersistent: Boolean) {
    class Persistent(val lastModified: Instant): State(true) {
        constructor(millis: Long): this(Instant.ofEpochMilli(millis))
    }
    class NotPersistent: State(false)
}