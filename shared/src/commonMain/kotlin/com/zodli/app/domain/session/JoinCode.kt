package com.zodli.app.domain.session

/**
 * Domain rule: a join code is a short, human-shareable identifier.
 * This file contains only the rules/shape, not any networking or persistence.
 */
@JvmInline
value class JoinCode private constructor(val value: String) {
    override fun toString(): String = value

    companion object {
        fun parse(raw: String): JoinCodeResult {
            val normalized = raw.trim().uppercase()

            if (normalized.length !in 4..8) {
                return JoinCodeResult.Invalid(JoinCodeError.Length)
            }
            if (!normalized.all { it.isLetterOrDigit() }) {
                return JoinCodeResult.Invalid(JoinCodeError.Characters)
            }

            return JoinCodeResult.Valid(JoinCode(normalized))
        }
    }
}

sealed interface JoinCodeResult {
    data class Valid(val code: JoinCode) : JoinCodeResult
    data class Invalid(val error: JoinCodeError) : JoinCodeResult
}

sealed interface JoinCodeError {
    data object Length : JoinCodeError
    data object Characters : JoinCodeError
}
