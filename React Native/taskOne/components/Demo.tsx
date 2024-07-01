import { View, Text, Button } from 'react-native'
import React from 'react'

const Demo = ({ navigation }: any) => {
  return (
    <View style={{flex: 1, flexDirection: 'column', justifyContent: 'center', gap: 10, marginHorizontal: 16}}>
        <Button title='Screen1' onPress={() => navigation.navigate('Screen1')} />
        <Button title='Screen2' onPress={() => navigation.navigate('Screen2')} />
        <Button title='Screen3' onPress={() => navigation.navigate('Screen3')} />
        <Button title='Screen4' onPress={() => navigation.navigate('Screen4')} />
        <Button title='Screen5' onPress={() => navigation.navigate('Screen5')} />
        <Button title='Screen6' onPress={() => navigation.navigate('Screen6')} />
        <Button title='Screen7' onPress={() => navigation.navigate('Screen7')} />
    </View>
  )
}

export default Demo