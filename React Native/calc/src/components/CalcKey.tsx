import React, { FC } from 'react';
import { TouchableOpacity, Text, StyleSheet } from 'react-native';
import { CalcKeyProps } from '../@types/globalTypes';

const CalcKey: FC<CalcKeyProps> = ({ keyValue, onClick }) => {
  return (
    <TouchableOpacity
      style={[styles.calcBtn]}
      onPress={() => onClick(keyValue)}
    >
      <Text style={styles.calcBtnText}>{keyValue}</Text>
    </TouchableOpacity>
  );
}

const styles = StyleSheet.create({
    calcBtn: {
      width: 84,
      height: 84,
      margin: 8,
      textAlign: 'center',
      justifyContent: 'center',
      alignItems: 'center',
      fontSize: 48,
      borderRadius: 16,
      backgroundColor: '#ffffff',
      elevation: 2,
      shadowColor: '#bbbbbb',
      shadowOffset: { width: 0.1, height: 0.1 },
      shadowOpacity: 0.3,
      shadowRadius: 0.1,
    },
    calcBtnText: {
      fontSize: 32,
    },
  });
  
  export default CalcKey;