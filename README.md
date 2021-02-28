# Twitter Splash Screen : Motion Layout Demo

## App Demo

<img src="https://user-images.githubusercontent.com/43718257/109408373-12686000-79af-11eb-998c-4d2e70a4296c.gif" width="250" height="470">


### Splash Screen

This is the first screen that comes to a user's view when an app launches. Splash screens usually display an animation of the logo but the more complex ones may also show some  animations based around the entire theme of the app.


### Motion Layout

[MotionLayout](https://developer.android.com/training/constraint-layout/motionlayout) is intended to move, resize, and animate UI elements with which users interact, such as buttons and title bars. It is meant to add not only gratuitous special effects in an app, but also to create motions that help users understand what the app is doing.

* [Build Complex layout transitions easily](https://material.io/design/motion/understanding-motion.html#brand-expression):
It bridges the gap between layout transitions and complex motion handling, offering a mix of features between the property animation framework, TransitionManager, and CoordinatorLayout.

* [Seekable Transitions via Keyframes](https://medium.com/google-developers/defining-motion-paths-in-motionlayout-6095b874d37):
It inherently supports seekable transitions. This means that you can instantly show any point within the transition based on some condition, such as touch input. MotionLayout also supports keyframes, enabling fully customized transitions to suit your needs.

* Write less Code :
One of the coolest things about it is that it's declarative, meaning you can describe any transitions in XML, no matter how complex.


## Steps

### Add Dependency

Androidx:
```
dependencies {
    implementation 'androidx.constraintlayout:constraintlayout:2.0.0-beta1'
}
```
else

``` dependencies {
    implementation 'com.android.support.constraint:constraint-layout:2.0.0-beta1'
}
```

### Convert the current ConstraintLayout to MotionLayout

```Kotlin
<!-- before: ConstraintLayout -->
<androidx.constraintlayout.widget.ConstraintLayout .../>
<!-- after: MotionLayout -->
<androidx.constraintlayout.motion.widget.MotionLayout .../>
```

### Create a Motion Scene

A MotionScene is an XML resource file that contains all of the motion descriptions for the corresponding layout. To keep layout information separate from motion descriptions, each MotionLayout references a separate MotionScene.

```Kotlin
<?xml version="1.0" encoding="utf-8"?>
<MotionScene xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:motion="http://schemas.android.com/apk/res-auto">

    <Transition
        ...>
        <OnSwipe
            ... />
    </Transition>

    <ConstraintSet android:id="@+id/start">
        <Constraint
            ... />
    </ConstraintSet>

    <ConstraintSet android:id="@+id/end">
        <Constraint
            ... />
    </ConstraintSet>

</MotionScene>
```

Also, add CustomAttribute to each ConstraintSet elements.

### Create a Handler in the SplashActivity for the motion

```Kotlin
Handler().postDelayed({ 
            /* Create an Intent that will start the Menu-Activity. */
            val mainIntent = Intent(this, LoginActivity::class.java)
            this.startActivity(mainIntent)

            // remove the Splash Activity from the stack (since we only want to show it once i.e., at the v beginning)
            this.finish()
        }, 1000)
```

