import React, { useEffect } from 'react'
import { NavigationContainer, createNavigationContainerRef } from '@react-navigation/native'
import { createStackNavigator } from '@react-navigation/stack';
import { Button, ButtonText } from '@gluestack-ui/themed';
import { useAuthContext } from '../contexts/authProvider';
import { createTable, getUsers } from '../db/databaseService';
import Home from '../screens/Home';
import Login from '../screens/Login';
import Signup from '../screens/Signup';
import Splash from '../screens/Splash';
import Admin from '../screens/Admin';


const MainNavigation = () => {
    const Stack = createStackNavigator();
    const navigationRef = createNavigationContainerRef();
    const { logoutUser } = useAuthContext()

    const getAllUsers = async () => {
        const result = await getUsers();
        const data: any = result ? (result.length > 0 ? result[0].rows : []) : [];
        console.log(data)
        for (let i = 0; i < data.length; i++) {
            console.log(data.item(i));
        }
    }

    const handleLogout = () => {
        logoutUser(navigationRef)
    }

    useEffect(() => {
        getAllUsers();
    }, [])

    return (
        <NavigationContainer ref={navigationRef}>
            <Stack.Navigator>
                <Stack.Screen name="Splash" component={Splash} options={{ headerShown: false }} />
                <Stack.Screen name="Home" component={Home} options={{
                    headerRight: () => (
                        <Button
                            size="sm"
                            variant="outline"
                            action="negative"
                            mr="$3"
                            onPress={handleLogout}
                        >
                            <ButtonText>Logout</ButtonText>
                        </Button>
                    ),
                }} />
                <Stack.Screen name="Admin" component={Admin} options={{
                    headerRight: () => (
                        <Button
                            size="sm"
                            variant="outline"
                            action="negative"
                            mr="$3"
                            onPress={handleLogout}
                        >
                            <ButtonText>Logout</ButtonText>
                        </Button>
                    ),
                }} />
                <Stack.Screen name="Login" component={Login} options={{ headerShown: false }} />
                <Stack.Screen name="Signup" component={Signup} options={{ headerShown: false }} />
            </Stack.Navigator>
        </NavigationContainer>
    )
}

export default MainNavigation