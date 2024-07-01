import { useState, useEffect } from "react";
import CalcKey from "./components/CalcKey";
import { CalcOpType } from "./@types/globalTypes";

function App() {
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
    <div className="calculator">
      <div className="calculator-input">
        <div className="result">{prevValue} </div>
        <div className="result">{op} </div>
        <div className="result">{nextValue} </div>
      </div>
      <div className="calculator-keypad">
        <div className="keys-function">
          <CalcKey keyValue={"c"} onClick={handleOperation} />
          <CalcKey keyValue={"\xB1"} onClick={handleOperation} />
          <CalcKey keyValue={"%"} onClick={handleOperation} />
        </div>
        <div className="keys-operators">
          <CalcKey keyValue={"+"} onClick={handleOperation} />
          <CalcKey keyValue={"-"} onClick={handleOperation} />
          <CalcKey keyValue={"*"} onClick={handleOperation} />
          <CalcKey keyValue={"/"} onClick={handleOperation} />
          <CalcKey keyValue={"="} onClick={handleOperation} />
        </div>
        <div className="keys-numbers">
          <CalcKey keyValue={9} onClick={handleOperation} />
          <CalcKey keyValue={8} onClick={handleOperation} />
          <CalcKey keyValue={7} onClick={handleOperation} />
          <CalcKey keyValue={6} onClick={handleOperation} />
          <CalcKey keyValue={5} onClick={handleOperation} />
          <CalcKey keyValue={4} onClick={handleOperation} />
          <CalcKey keyValue={3} onClick={handleOperation} />
          <CalcKey keyValue={2} onClick={handleOperation} />
          <CalcKey keyValue={1} onClick={handleOperation} />
          <CalcKey
            className="key-dot"
            keyValue={"."}
            onClick={handleOperation}
          />
          <CalcKey
            className="key-zero"
            keyValue={0}
            onClick={handleOperation}
          />
        </div>
      </div>
    </div>
  );
}

export default App;
