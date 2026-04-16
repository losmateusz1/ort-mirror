package org.ossreviewtoolkit.model.config

import com.fasterxml.jackson.annotation.JsonInclude

import org.ossreviewtoolkit.model.Identifier

/**
 * Defines a dependency that should be excluded. Each dependency whose [Identifier.toCoordinates] is matched by
 * [pattern] is marked as excluded.
 */
data class DependencyExclude(
    /**
     * A regular expression to match the [coordinates][Identifier.toCoordinates] of dependencies to exclude.
     */
    val pattern: String,

    /**
     * The reason why the dependency is excluded, out of a predefined choice.
     */
    val reason: DependencyExcludeReason,

    /**
     * A comment to further explain why the [reason] is applicable here.
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val comment: String = ""
) {
    private val regex by lazy { Regex(pattern) }

    /**
     * Return true if and only if this [DependencyExclude] matches the given [identifier].
     */
    fun matches(identifier: Identifier) = regex.matches(identifier.toCoordinates())
}
