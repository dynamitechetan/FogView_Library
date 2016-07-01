# Fog View Android Library

## Screnshots

![Screenshot](screenshots/screen1.gif)    ![Screenshot](screenshots/screen2.gif)


## How to use

If you want use this library, you can download project and import it into your workspace and add the project as a library in your android project settings.

Or you can use the gradle dependency, you have to add these lines in your build.gradle file:

```xml
repositories {
	maven {
            url 'https://dl.bintray.com/dynamitechetan/maven'
        }
}

dependencies {
    compile 'com.dynamitechetan.fogviewlibrary:FogViewLibrary:1.0.0@aar'
    
}
```
The FogView have some custom attributes, to use them , you must add this line in your xml file in the first component:

```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:fog="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    >
</RelativeLayout>
```

## BASIC USAGE
```xml
 <com.dynamitechetan.fogviewlibrary.FogView
        android:id="@+id/RubFog"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
  />
```
## USING A CUSTOM FOG IMAGE

```xml
 <com.dynamitechetan.fogviewlibrary.FogView
        android:id="@+id/RubFog"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
		fog:fog_image="@drawable/my_fog_image"
  />
```
### Two fog images are provided with the library, to use them:
```xml
        fog:fog_image="@drawable/fog"
```
or
use this for a denser fog image
```xml
        fog:fog_image="@drawable/fog_dense"
```

## USING A CUSTOM STROKE WIDTH
Default Stroke Width is 75
```xml
        fog:stroke_width="100"
```


## Contributions are welcome!!
