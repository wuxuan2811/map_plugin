import 'package:flutter/material.dart';
import 'package:spaceon_map_plugin/map_view.dart';
import 'package:spaceon_map_plugin/spaceon_map_plugin.dart';

void main() => runApp(MaterialApp(home: MapViewExample()));

class MapViewExample extends StatelessWidget {
  SpaceonMapPlugin mapContoller;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: const Text('Flutter MapView example')),
        /*body: Container(
            child: MapView())*/
        body: Stack(
          children: <Widget>[
            Container(child: MapView(onTextViewCreated: _onTextViewCreated)),
            Container(
              padding: EdgeInsets.only(right: 5.0),
              alignment: Alignment.centerRight,
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  IconButton(
                      icon: Icon(Icons.zoom_in),
                      iconSize: 32,
                      onPressed: zoomIn),
                  IconButton(
                      icon: Icon(Icons.zoom_out),
                      iconSize: 32,
                      onPressed: zoomOut)
                ],
              ),
            ),
          ],
        ));
  }

  _onTextViewCreated(SpaceonMapPlugin controller) {
    mapContoller = controller;
  }

  zoomIn() {
    mapContoller.zoomIn();
  }

  zoomOut() {
    mapContoller.zoomOut();
  }
}
