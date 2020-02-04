# NYTimesMostPopularArticles_MVVM_Kotlin (Clean_Architecture)

This repository contains a simple app to hit the NY Times Most Popular Articles API and show a list of articles, that shows details when items on the list are tapped (a typical master/detail app), also user able to browse/ add articles to favorite list that implements MVVM architecture using Dagger2, RxJava2, FastAndroidNetworking, LiveData, RoomDatabase, Database Debugging, DataBinding and Navigation Component.

<br>
<p align="center">
    <img src="page1.jpg" width="250"/>
    <img src="page2.jpg" width="250"/>
    <img src="page3.jpg" width="250"/>
</p>
<br>

## The app has following packages:
1. **data**: It contains all the data accessing and manipulating components.
2. **di**: Dependency providing classes using Dagger2.
3. **ui**: View classes along with their corresponding Presenters.
4. **utils**: Utility classes.
#### Classes have been designed in such a way that it could be inherited and maximize the code reuse.
<br>

## Project Structure
<p align="center">
    <img src="project_arch_screen.jpg"/>
</p>
<br>

## Navigation Component Graph
<p align="center">
    <img src="nav_graph.png"/>
</p>
<br>

## Guide to app architecture
<p align="center">
    <img src="architecture.png"/>
</p>
<br>

## Library reference resources:
1. RxJava2: https://github.com/ReactiveX/RxJava
2. RxAndroid: https://github.com/ReactiveX/RxAndroid
3. Dagger2: https://github.com/MindorksOpenSource/android-dagger2-example
4. FastAndroidNetworking: https://github.com/amitshekhariitbhu/Fast-Android-Networking
5. Room: https://developer.android.com/topic/libraries/architecture/room.html
6. AndroidDebugDatabase: https://github.com/amitshekhariitbhu/Android-Debug-Database
7. DataBinding: https://developer.android.com/topic/libraries/data-binding
8. Navigation Component: https://developer.android.com/guide/navigation/navigation-getting-started
<br>

#### Java version: https://github.com/AmrAbdelhameed/NYTimesMostPopularArticles_MVVM

## License
```
   Copyright (C) 2019 Amr Abdelhameed

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```