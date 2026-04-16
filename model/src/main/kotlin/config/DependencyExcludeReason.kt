package org.ossreviewtoolkit.model.config

/**
 * Possible reasons for excluding a dependency.
 */
enum class DependencyExcludeReason {
    /**
     * The dependency is only used for building source code and is not included in distributed build artifacts.
     */
    BUILD_DEPENDENCY_OF,

    /**
     * The dependency is only used during development and is not included in distributed build artifacts.
     */
    DEV_DEPENDENCY_OF,

    /**
     * The dependency is only used for building the documentation and is not included in distributed build artifacts.
     */
    DOCUMENTATION_DEPENDENCY_OF,

    /**
     * A fallback reason for the [DependencyExcludeReason] when none of the other reasons apply.
     */
    OTHER,

    /**
     * The dependency has to be provided by the user of the distributed build artifacts.
     */
    PROVIDED_DEPENDENCY_OF,

    /**
     * The dependency is only used for testing and is not included in distributed build artifacts.
     */
    TEST_DEPENDENCY_OF,

    /**
     * The dependency is only used at runtime by the user of the distributed build artifacts but is not included in
     * those artifacts.
     */
    RUNTIME_DEPENDENCY_OF
}
