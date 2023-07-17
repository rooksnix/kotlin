Certainly! Here's a Kotlin program that uses the Android Sensor API to retrieve details of all available smartphone sensors and write them to a text file on the Android filesystem:

```kotlin
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import java.io.File
import java.io.FileWriter

fun writeSensorDetailsToFile(context: Context, fileName: String) {
    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL)

    val file = File(context.filesDir, fileName)
    val fileWriter = FileWriter(file)

    for (sensor in sensorList) {
        fileWriter.write("Name: ${sensor.name}\n")
        fileWriter.write("Type: ${sensor.stringType}\n")
        fileWriter.write("Vendor: ${sensor.vendor}\n")
        fileWriter.write("Version: ${sensor.version}\n")
        fileWriter.write("Maximum Range: ${sensor.maximumRange}\n")
        fileWriter.write("Power: ${sensor.power}\n")
        fileWriter.write("Resolution: ${sensor.resolution}\n")
        fileWriter.write("Minimum Delay: ${sensor.minDelay}\n")

        fileWriter.write("\n")
    }

    fileWriter.close()
}

// Usage
val context: Context = /* get the context from your app */
val fileName = "sensor_details.txt"

writeSensorDetailsToFile(context, fileName)
```

In this program, we use the `SensorManager` to retrieve a list of all available sensors on the device using `getSensorList(Sensor.TYPE_ALL)`. We then iterate over the list and write the sensor details to a text file specified by `fileName`.

Make sure you have the necessary permissions set in your AndroidManifest.xml file to read and write to external storage if you want to store the file outside of the app's internal storage.
