# AutoAdjustmentLayout (Alpha)

Android custom view which allows to set a List of Objects (extends of View) that will be placed one-by-one whith auto transfering function to the next line, according to items and parent layout width.

![alt tag](https://raw.github.com/zhuchinskyi/AutoAdjustmentLayout/master/smart_screen.png)

Features:
---

- set/add item(s)
- remove item dynamically
- receive callbacks (item has been removed & end achived)
 
Declare in XML:
---
```xml
  <com.compoundview.autoadjustmentlayout.AutoAdjustmentLayout
            android:id="@+id/autoAdjustmentLayout"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"/>
```

Code:
---

```java
AutoAdjustmentLayout autoAdjustmentLayout = (AutoAdjustmentLayout) findViewById(R.id.autoAdjustmentView);
autoAdjustmentLayout.setElementList(ArrayList<Object>);
autoAdjustmentLayout.isRemovable(true);

autoAdjustmentLayout.setAutoAdjustmentLayoutListener(new AutoAdjustmentLayout.IOnAutoAdjustmentLayoutListener() {
          @Override
          public void onItemRemoved(View view) {
          
          }
          @Override
          public void onLastItemRemoved(View view) {
          
          }
        });
  }
  ```
  
  To append items dynamically:
  
  ```java
autoAdjustmentLayout.addElement(Object);
autoAdjustmentLayout.addElementList(ArrayList<Object>);
 ```
  To remove item dynamically:
  
  ```java
autoAdjustmentLayout.removeElement(Object);
 ```
 
 Usage
-----
![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.stanfy.enroscar/enroscar-goro/badge.svg)

AutoAdjustmentLayout is an Android library packaged as AAR and available in Maven Central.
Add this dependency to your Android project in `build.gradle`:
```groovy
dependencies {
  compile 'compile 'com.github.zhuchinskyi:autoadjustmentlayout:0.0.1'
}
```
Otherwise, you can download library and append as module to your project.
 
 License
-------

     Copyright 2015 Denys Zhuchinskyi

     Licensed under the Apache License, Version 2.0 (the "License");
     you may not use this file except in compliance with the License.
     You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

     Unless required by applicable law or agreed to in writing, software
     distributed under the License is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     See the License for the specific language governing permissions and
     limitations under the License.
