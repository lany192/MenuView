# MenuView
[![](https://jitpack.io/v/lany192/MenuView.svg)](https://jitpack.io/#lany192/MenuView)
## Add it in your root build.gradle at the end of repositories:

    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
    
## Step 2. Add the dependency

    dependencies {
        compile 'com.github.lany192:MenuView:1.0.1'
    }

## Step 3. Use in layout

    <com.github.lany192.menu.MenuView
        android:id="@+id/my_signin_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:menu_icon="@drawable/vector_android"
        app:menu_name="menu1" />