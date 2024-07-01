import React from 'react';
import {
  Image,
  SafeAreaView,
  ScrollView,
  StatusBar,
  Text,
} from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import Screen1 from './screens/Screen1';
import Screen2 from './screens/Screen2';
import { createDrawerNavigator } from '@react-navigation/drawer';
import Screen3 from './screens/Screen3';
import { Button } from 'react-native';
import { TouchableHighlight } from 'react-native';
import { View } from 'react-native';
import Screen4 from './screens/Screen4';
import { createStackNavigator } from '@react-navigation/stack';
import Demo from './components/Demo';
import Screen5 from './screens/Screen5';
import Screen6 from './screens/Screen6';
import Screen7 from './screens/Screen7';

const Drawer = createDrawerNavigator();

const Tab = createBottomTabNavigator();

const Stack = createStackNavigator();

function App(): React.JSX.Element {
  return (
    <SafeAreaView style={{ flex: 1 }}>
      <StatusBar
        barStyle='light-content'
        backgroundColor="deeppink"
      />
      {/* <NavigationContainer>
          <Tab.Navigator
            screenOptions={({ route }) => ({
              tabBarIcon: ({ focused, color, size }) => {
                let iconName;
    
                if (route.name === 'Screen1') {
                  iconName = focused
                    ? 'https://cdn-icons-png.flaticon.com/512/11516/11516559.png'
                    : 'https://cdn-icons-png.flaticon.com/512/11516/11516605.png';
                } else if (route.name === 'Screen2') {
                  iconName = focused 
                    ? 'https://cdn-icons-png.flaticon.com/512/11517/11517121.png'
                    : 'https://cdn-icons-png.flaticon.com/512/11517/11517122.png';
                }
  
                return <Image style={{height: size, width: size}} source={{uri: iconName}} />;
              },
              tabBarActiveTintColor: 'tomato',
              tabBarInactiveTintColor: 'gray',
            })}
          >
            <Tab.Screen name="Screen1" component={Screen1} />
            <Tab.Screen name="Screen2" component={Screen2} />
          </Tab.Navigator>
        </NavigationContainer> */}
      {/* <NavigationContainer>
        <Drawer.Navigator initialRouteName="Screen1">
          <Drawer.Screen
            name="Screen1"
            component={Screen1}
            options={{
              headerTitle: () => <Text style={{color: 'white', fontSize: 20}}>What are you looking for ?</Text>,
              headerStyle: {
                backgroundColor: 'deeppink',
              },
              headerTintColor: '#fff',
              headerRight: () => (
                <TouchableHighlight onPress={() => {}}>
                  <Image style={{width: 25, height: 25}} source={{uri: 'https://cdn-icons-png.flaticon.com/512/2311/2311524.png'}} />
                </TouchableHighlight>
              ),
            }}
          />
          <Drawer.Screen name="Screen2" component={Screen2} />
          <Drawer.Screen name="Screen3" component={Screen3} />
          <Drawer.Screen name="Screen4" component={Screen4} />
        </Drawer.Navigator>
      </NavigationContainer> */}

      <NavigationContainer>
        <Stack.Navigator>
          <Stack.Screen name="Demo" component={Demo} />
          <Stack.Screen
            name="Screen1"
            component={Screen1}
            options={{
              headerTitle: () => <Text style={{ color: 'white', fontSize: 20 }}>What are you looking for ?</Text>,
              headerStyle: {
                backgroundColor: 'deeppink',
              },
              headerTintColor: '#fff',
              headerRight: () => (
                <TouchableHighlight onPress={() => { }}>
                  <Image style={{ width: 25, height: 25, marginRight: 5 }} source={{ uri: 'https://cdn-icons-png.flaticon.com/512/2311/2311524.png' }} />
                </TouchableHighlight>
              ),
            }}
          />
          <Stack.Screen name="Screen2" component={Screen2} />
          <Stack.Screen name="Screen3" component={Screen3} />
          <Stack.Screen name="Screen4" component={Screen4} />
          <Stack.Screen name="Screen5" component={Screen5} />
          <Stack.Screen name="Screen6" component={Screen6} />
          <Stack.Screen name="Screen7" component={Screen7} />
        </Stack.Navigator>
      </NavigationContainer>

    </SafeAreaView>
  );
}

export default App;
