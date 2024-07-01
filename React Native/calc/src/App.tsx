import React, { useEffect, useState } from 'react';
import { SafeAreaView, ScrollView, StyleSheet, Text, TouchableOpacity, View } from 'react-native';
import { CalcOpType } from './@types/globalTypes';
import CalcKey from './components/CalcKey';

function App(): React.JSX.Element {
  const [prevValue, setPrevValue] = useState<string | null>(null);
  const [nextValue, setNextValue] = useState<string>("0");
  const [op, setOp] = useState<string | null>(null);

  useEffect(() => {}, [op, nextValue, prevValue]);

  const CalculatorOperations: CalcOpType = {
    "/": (a, b) => a / b,
    "*": (a, b) => a * b,
    "+": (a, b) => a + b,
    "-": (a, b) => a - b,
    "=": (_, b) => b,
  };

  const performOperation = () => {
    if (op) {
      let temp = CalculatorOperations[op](
        parseFloat(prevValue!),
        parseFloat(nextValue)
      );
      setOp(null);
      setNextValue(String(temp));
      setPrevValue(null);
    }
  };

  const handleNum = (number: number) => {
    setNextValue(nextValue === "0" ? String(number) : nextValue + number);
  };

  const insertDot = () => {
    if (!/\./.test(nextValue)) {
      setNextValue(nextValue + ".");
    }
  };

  const percentage = () => {
    setNextValue(parseFloat(nextValue) / 100 + "");
    if (prevValue && nextValue === "") {
      setPrevValue(parseFloat(prevValue) / 100 + "");
    }
  };

  const changeSign = () => {
    setNextValue(parseFloat(nextValue) * -1 + "");
  };

  const clearData = () => {
    setNextValue("0");
    setOp(null);
    setPrevValue(null);
  };

  const handleOperation = (value: string | number) => {
    if (typeof value === "number") {
      handleNum(value);
    } else if (value in CalculatorOperations) {
      if (op === null && value !== "=") {
        setOp(value);
        setPrevValue(nextValue);
        setNextValue("");
      }
      if (op && value !== "=") {
        setOp(value);
      }
      if (prevValue && op && nextValue) {
        performOperation();
      }
    } else if (value === "c") {
      clearData();
    } else if (value === "\xB1") {
      changeSign();
    } else if (value === ".") {
      insertDot();
    } else if (value === "%") {
      percentage();
    }
  };

  return (
    <SafeAreaView>
        <View style={styles.container}>
          <View style={[styles.calculatorInput]}>
            <Text style={styles.result}>{prevValue}</Text>
            <Text style={styles.result}>{op}</Text>
            <Text style={styles.result}>{nextValue}</Text>
          </View>
          <View style={[styles.calculatorKeypad]}>
              <CalcKey keyValue={"c"} onClick={handleOperation} />
              <CalcKey keyValue={"\xB1"} onClick={handleOperation} />
              <CalcKey keyValue={"%"} onClick={handleOperation} />
              <CalcKey keyValue={"+"} onClick={handleOperation} />

              <CalcKey keyValue={7} onClick={handleOperation} />
              <CalcKey keyValue={8} onClick={handleOperation} />
              <CalcKey keyValue={9} onClick={handleOperation} />
              <CalcKey keyValue={"-"} onClick={handleOperation} />


              <CalcKey keyValue={4} onClick={handleOperation} />
              <CalcKey keyValue={5} onClick={handleOperation} />
              <CalcKey keyValue={6} onClick={handleOperation} />
              <CalcKey keyValue={"*"} onClick={handleOperation} />

              <CalcKey keyValue={1} onClick={handleOperation} />
              <CalcKey keyValue={2} onClick={handleOperation} />
              <CalcKey keyValue={3} onClick={handleOperation} />
              <CalcKey keyValue={"/"} onClick={handleOperation} />

              <TouchableOpacity
                style={[styles.calcBtn, styles.keyZero]}
                onPress={() => handleOperation(0)}
              >
                <Text style={styles.calcBtnText}>0</Text>
              </TouchableOpacity>
              <TouchableOpacity
                style={[styles.calcBtn, styles.keyDot]}
                onPress={() => handleOperation('.')}
              >
                <Text style={styles.calcBtnText}>.</Text>
              </TouchableOpacity>
              <CalcKey keyValue={"="} onClick={handleOperation} />
            </View>
          </View>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    height: '100%',
    flexDirection: 'column',
    padding: '1%',
    backgroundColor: '#eeeeee',
  },
  calcBtnText: {
    fontSize: 32,
  },
  calculator: {
    backgroundColor: '#eeeeee',
    overflow: 'hidden',
  },
  keyZero: {
    width: 185,
    textAlign: 'left',
    paddingLeft: 45,
    paddingTop: 20,
  },
  keyDot: {
    paddingTop: 10,
    paddingLeft: 35
  },
  calculatorKeypad: {
    height: '70%',
    flexWrap: 'wrap',
    flexDirection: 'row',
    paddingTop: 3
  },
  calculatorInput: {
    height: '30%',
    borderWidth: 2,
    borderColor: '#999',
    borderRadius: 10,
    backgroundColor: '#fff',
    paddingRight: '8%',
    padding: 10,
    margin: 10,
    justifyContent: 'flex-end',
    alignItems: 'flex-end'
  },
  result: {
    color: '#666666',
    marginTop: 5,
    fontSize: 48,
    textAlign: 'right',
    fontWeight: 'bold'
  },
  calcBtn: {
    width: 84,
    height: 84,
    margin: 8,
    textAlign: 'center',
    fontSize: 48,
    borderRadius: 16,
    backgroundColor: '#ffffff',
    elevation: 2, // Android shadow
    shadowColor: '#bbbbbb', // iOS shadow
    shadowOffset: { width: 0.1, height: 0.1 },
    shadowOpacity: 0.3,
    shadowRadius: 0.1,
  },
});

export default App;
