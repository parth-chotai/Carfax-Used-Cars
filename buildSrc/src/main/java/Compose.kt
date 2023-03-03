object Compose {
    private const val activityComposeVersion = "1.5.1"
    const val activity = "androidx.activity:activity-compose:$activityComposeVersion"

    const val composeCompilerVersion = "1.3.0"
    const val composeVersion = "1.2.1"
    const val ui = "androidx.compose.ui:ui:$composeVersion"
    const val material = "androidx.compose.material:material:$composeVersion"
    const val tooling = "androidx.compose.ui:ui-tooling:$composeVersion"

    private const val navigationVersion = "2.5.1"
    const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"

    // Debug for profiling
    const val ui_tooling = "androidx.compose.ui:ui-tooling:$composeVersion"
    const val ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
}

object ComposeTest {
    const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${Compose.composeVersion}"
    const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${Compose.composeVersion}"
}