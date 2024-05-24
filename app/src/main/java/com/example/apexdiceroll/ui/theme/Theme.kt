package com.example.apexdiceroll.ui.theme
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Immutable
data class ExtendedColorScheme(
    val assault: ColorFamily,
    val skirmisher: ColorFamily,
    val recon: ColorFamily,
    val support: ColorFamily,
    val controller: ColorFamily,
    val common: ColorFamily,
    val rare: ColorFamily,
    val epic: ColorFamily,
    val legendary: ColorFamily,
    val mythic: ColorFamily,
)

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

val extendedLight = ExtendedColorScheme(
  assault = ColorFamily(
  assaultLight,
  onAssaultLight,
  assaultContainerLight,
  onAssaultContainerLight,
  ),
  skirmisher = ColorFamily(
  skirmisherLight,
  onSkirmisherLight,
  skirmisherContainerLight,
  onSkirmisherContainerLight,
  ),
  recon = ColorFamily(
  reconLight,
  onReconLight,
  reconContainerLight,
  onReconContainerLight,
  ),
  support = ColorFamily(
  supportLight,
  onSupportLight,
  supportContainerLight,
  onSupportContainerLight,
  ),
  controller = ColorFamily(
  controllerLight,
  onControllerLight,
  controllerContainerLight,
  onControllerContainerLight,
  ),
  common = ColorFamily(
  commonLight,
  onCommonLight,
  commonContainerLight,
  onCommonContainerLight,
  ),
  rare = ColorFamily(
  rareLight,
  onRareLight,
  rareContainerLight,
  onRareContainerLight,
  ),
  epic = ColorFamily(
  epicLight,
  onEpicLight,
  epicContainerLight,
  onEpicContainerLight,
  ),
  legendary = ColorFamily(
  legendaryLight,
  onLegendaryLight,
  legendaryContainerLight,
  onLegendaryContainerLight,
  ),
  mythic = ColorFamily(
  mythicLight,
  onMythicLight,
  mythicContainerLight,
  onMythicContainerLight,
  ),
)

val extendedDark = ExtendedColorScheme(
  assault = ColorFamily(
  assaultDark,
  onAssaultDark,
  assaultContainerDark,
  onAssaultContainerDark,
  ),
  skirmisher = ColorFamily(
  skirmisherDark,
  onSkirmisherDark,
  skirmisherContainerDark,
  onSkirmisherContainerDark,
  ),
  recon = ColorFamily(
  reconDark,
  onReconDark,
  reconContainerDark,
  onReconContainerDark,
  ),
  support = ColorFamily(
  supportDark,
  onSupportDark,
  supportContainerDark,
  onSupportContainerDark,
  ),
  controller = ColorFamily(
  controllerDark,
  onControllerDark,
  controllerContainerDark,
  onControllerContainerDark,
  ),
  common = ColorFamily(
  commonDark,
  onCommonDark,
  commonContainerDark,
  onCommonContainerDark,
  ),
  rare = ColorFamily(
  rareDark,
  onRareDark,
  rareContainerDark,
  onRareContainerDark,
  ),
  epic = ColorFamily(
  epicDark,
  onEpicDark,
  epicContainerDark,
  onEpicContainerDark,
  ),
  legendary = ColorFamily(
  legendaryDark,
  onLegendaryDark,
  legendaryContainerDark,
  onLegendaryContainerDark,
  ),
  mythic = ColorFamily(
  mythicDark,
  onMythicDark,
  mythicContainerDark,
  onMythicContainerDark,
  ),
)

val extendedLightMediumContrast = ExtendedColorScheme(
  assault = ColorFamily(
  assaultLightMediumContrast,
  onAssaultLightMediumContrast,
  assaultContainerLightMediumContrast,
  onAssaultContainerLightMediumContrast,
  ),
  skirmisher = ColorFamily(
  skirmisherLightMediumContrast,
  onSkirmisherLightMediumContrast,
  skirmisherContainerLightMediumContrast,
  onSkirmisherContainerLightMediumContrast,
  ),
  recon = ColorFamily(
  reconLightMediumContrast,
  onReconLightMediumContrast,
  reconContainerLightMediumContrast,
  onReconContainerLightMediumContrast,
  ),
  support = ColorFamily(
  supportLightMediumContrast,
  onSupportLightMediumContrast,
  supportContainerLightMediumContrast,
  onSupportContainerLightMediumContrast,
  ),
  controller = ColorFamily(
  controllerLightMediumContrast,
  onControllerLightMediumContrast,
  controllerContainerLightMediumContrast,
  onControllerContainerLightMediumContrast,
  ),
  common = ColorFamily(
  commonLightMediumContrast,
  onCommonLightMediumContrast,
  commonContainerLightMediumContrast,
  onCommonContainerLightMediumContrast,
  ),
  rare = ColorFamily(
  rareLightMediumContrast,
  onRareLightMediumContrast,
  rareContainerLightMediumContrast,
  onRareContainerLightMediumContrast,
  ),
  epic = ColorFamily(
  epicLightMediumContrast,
  onEpicLightMediumContrast,
  epicContainerLightMediumContrast,
  onEpicContainerLightMediumContrast,
  ),
  legendary = ColorFamily(
  legendaryLightMediumContrast,
  onLegendaryLightMediumContrast,
  legendaryContainerLightMediumContrast,
  onLegendaryContainerLightMediumContrast,
  ),
  mythic = ColorFamily(
  mythicLightMediumContrast,
  onMythicLightMediumContrast,
  mythicContainerLightMediumContrast,
  onMythicContainerLightMediumContrast,
  ),
)

val extendedLightHighContrast = ExtendedColorScheme(
  assault = ColorFamily(
  assaultLightHighContrast,
  onAssaultLightHighContrast,
  assaultContainerLightHighContrast,
  onAssaultContainerLightHighContrast,
  ),
  skirmisher = ColorFamily(
  skirmisherLightHighContrast,
  onSkirmisherLightHighContrast,
  skirmisherContainerLightHighContrast,
  onSkirmisherContainerLightHighContrast,
  ),
  recon = ColorFamily(
  reconLightHighContrast,
  onReconLightHighContrast,
  reconContainerLightHighContrast,
  onReconContainerLightHighContrast,
  ),
  support = ColorFamily(
  supportLightHighContrast,
  onSupportLightHighContrast,
  supportContainerLightHighContrast,
  onSupportContainerLightHighContrast,
  ),
  controller = ColorFamily(
  controllerLightHighContrast,
  onControllerLightHighContrast,
  controllerContainerLightHighContrast,
  onControllerContainerLightHighContrast,
  ),
  common = ColorFamily(
  commonLightHighContrast,
  onCommonLightHighContrast,
  commonContainerLightHighContrast,
  onCommonContainerLightHighContrast,
  ),
  rare = ColorFamily(
  rareLightHighContrast,
  onRareLightHighContrast,
  rareContainerLightHighContrast,
  onRareContainerLightHighContrast,
  ),
  epic = ColorFamily(
  epicLightHighContrast,
  onEpicLightHighContrast,
  epicContainerLightHighContrast,
  onEpicContainerLightHighContrast,
  ),
  legendary = ColorFamily(
  legendaryLightHighContrast,
  onLegendaryLightHighContrast,
  legendaryContainerLightHighContrast,
  onLegendaryContainerLightHighContrast,
  ),
  mythic = ColorFamily(
  mythicLightHighContrast,
  onMythicLightHighContrast,
  mythicContainerLightHighContrast,
  onMythicContainerLightHighContrast,
  ),
)

val extendedDarkMediumContrast = ExtendedColorScheme(
  assault = ColorFamily(
  assaultDarkMediumContrast,
  onAssaultDarkMediumContrast,
  assaultContainerDarkMediumContrast,
  onAssaultContainerDarkMediumContrast,
  ),
  skirmisher = ColorFamily(
  skirmisherDarkMediumContrast,
  onSkirmisherDarkMediumContrast,
  skirmisherContainerDarkMediumContrast,
  onSkirmisherContainerDarkMediumContrast,
  ),
  recon = ColorFamily(
  reconDarkMediumContrast,
  onReconDarkMediumContrast,
  reconContainerDarkMediumContrast,
  onReconContainerDarkMediumContrast,
  ),
  support = ColorFamily(
  supportDarkMediumContrast,
  onSupportDarkMediumContrast,
  supportContainerDarkMediumContrast,
  onSupportContainerDarkMediumContrast,
  ),
  controller = ColorFamily(
  controllerDarkMediumContrast,
  onControllerDarkMediumContrast,
  controllerContainerDarkMediumContrast,
  onControllerContainerDarkMediumContrast,
  ),
  common = ColorFamily(
  commonDarkMediumContrast,
  onCommonDarkMediumContrast,
  commonContainerDarkMediumContrast,
  onCommonContainerDarkMediumContrast,
  ),
  rare = ColorFamily(
  rareDarkMediumContrast,
  onRareDarkMediumContrast,
  rareContainerDarkMediumContrast,
  onRareContainerDarkMediumContrast,
  ),
  epic = ColorFamily(
  epicDarkMediumContrast,
  onEpicDarkMediumContrast,
  epicContainerDarkMediumContrast,
  onEpicContainerDarkMediumContrast,
  ),
  legendary = ColorFamily(
  legendaryDarkMediumContrast,
  onLegendaryDarkMediumContrast,
  legendaryContainerDarkMediumContrast,
  onLegendaryContainerDarkMediumContrast,
  ),
  mythic = ColorFamily(
  mythicDarkMediumContrast,
  onMythicDarkMediumContrast,
  mythicContainerDarkMediumContrast,
  onMythicContainerDarkMediumContrast,
  ),
)

val extendedDarkHighContrast = ExtendedColorScheme(
  assault = ColorFamily(
  assaultDarkHighContrast,
  onAssaultDarkHighContrast,
  assaultContainerDarkHighContrast,
  onAssaultContainerDarkHighContrast,
  ),
  skirmisher = ColorFamily(
  skirmisherDarkHighContrast,
  onSkirmisherDarkHighContrast,
  skirmisherContainerDarkHighContrast,
  onSkirmisherContainerDarkHighContrast,
  ),
  recon = ColorFamily(
  reconDarkHighContrast,
  onReconDarkHighContrast,
  reconContainerDarkHighContrast,
  onReconContainerDarkHighContrast,
  ),
  support = ColorFamily(
  supportDarkHighContrast,
  onSupportDarkHighContrast,
  supportContainerDarkHighContrast,
  onSupportContainerDarkHighContrast,
  ),
  controller = ColorFamily(
  controllerDarkHighContrast,
  onControllerDarkHighContrast,
  controllerContainerDarkHighContrast,
  onControllerContainerDarkHighContrast,
  ),
  common = ColorFamily(
  commonDarkHighContrast,
  onCommonDarkHighContrast,
  commonContainerDarkHighContrast,
  onCommonContainerDarkHighContrast,
  ),
  rare = ColorFamily(
  rareDarkHighContrast,
  onRareDarkHighContrast,
  rareContainerDarkHighContrast,
  onRareContainerDarkHighContrast,
  ),
  epic = ColorFamily(
  epicDarkHighContrast,
  onEpicDarkHighContrast,
  epicContainerDarkHighContrast,
  onEpicContainerDarkHighContrast,
  ),
  legendary = ColorFamily(
  legendaryDarkHighContrast,
  onLegendaryDarkHighContrast,
  legendaryContainerDarkHighContrast,
  onLegendaryContainerDarkHighContrast,
  ),
  mythic = ColorFamily(
  mythicDarkHighContrast,
  onMythicDarkHighContrast,
  mythicContainerDarkHighContrast,
  onMythicContainerDarkHighContrast,
  ),
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun ApexDiceRollTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }
  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      val window = (view.context as Activity).window
      window.statusBarColor = Color.Transparent.toArgb()
      WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
    }
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}
