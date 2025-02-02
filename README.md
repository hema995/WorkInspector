# WorkInspector

Library to inspect the Android WorkManager jobs. Like an App inspector, but on a device. 

[![](https://jitpack.io/v/hema995/workinspector.svg)](https://jitpack.io/#hema995/workinspector) ![minSdk21](https://img.shields.io/badge/minSdk-21-red) ![Kotlin](https://img.shields.io/github/languages/top/hema995/workinspector)

### Screenshots

| ![](https://github.com/hema995/WorkInspector/raw/master/metadata/images/0.png) | ![](https://github.com/hema995/WorkInspector/raw/master/metadata/images/1.png) | ![](https://github.com/hema995/WorkInspector/raw/master/metadata/images/2.png) |
|---------------------------------------------------------------------------------|---------------------------------------------------------------------------------|---------------------------------------------------------------------------------|

## Usage

1. Add it to your root build.gradle at the end of repositories:

   ```groovy
   allprojects {
	   repositories {
		   ...
		   maven { url 'https://jitpack.io' }
	   }
   }
   ```

2. Add the dependency

    ```groovy
    dependencies {
        debugImplementation("com.github.hema995:workinspector:$version")
    }
    ```

   Versions are available on [JitPack](https://jitpack.io/#hema995/workinspector)

3. Usage

   The WorkInspector will be available via the launcher icon.

   Alternatively, you can disable the launcher icon and open it programmatically:

   ```xml
   <bool name="wi_launcher_icon_enabled" tools:node="replace">false</bool>
   ```

   ```kotlin
   // start activity
   context.startActivity(WorkInspector.getIntent(context))

   // or alternatively, for the debug-only implementation
   if (BuildConfig.DEBUG) {
     val intent = Intent()
     intent.component = ComponentName(context, "org.hema995.workinspector.WorkInspectorActivity")
     context.startActivity(intent)
   }
   ```