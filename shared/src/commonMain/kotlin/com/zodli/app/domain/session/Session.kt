package com.zodli.app.domain.session

data class Session(
    val id: SessionId,
    val joinCode: JoinCode,
)

@JvmInline
value class SessionId(val value: String)

