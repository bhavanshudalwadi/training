import { StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'
import MapView, { Marker } from 'react-native-maps'

const Screen5 = () => {
  return (
    <View style={{flex: 1}}>
      <MapView
        style={{flex: 1}}
        initialRegion={{
          latitude: 23,
          longitude: 72.55,
          latitudeDelta: 10,
          longitudeDelta: 10,
        }}
      />
    </View>
  )
}

export default Screen5

const styles = StyleSheet.create({

})