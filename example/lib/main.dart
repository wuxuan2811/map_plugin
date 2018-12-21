import 'package:flutter/material.dart';
import 'package:spaceon_map_plugin/map_view.dart';
import 'package:spaceon_map_plugin/spaceon_map_plugin.dart';

void main() => runApp(MaterialApp(home: MapViewExample()));

class MapViewExample extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: const Text('Flutter MapView example')),
        body: Container(
            child: MapView()));
  }

  void _onTextViewCreated(SpaceonMapPlugin controller) {
    //controller.setText('Hello from Android!');
  }
}
