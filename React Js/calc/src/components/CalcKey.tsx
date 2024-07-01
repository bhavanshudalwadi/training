import { memo, FC } from "react";
import { CalcKeyProps } from "../@types/globalTypes";

const CalcKey: FC<CalcKeyProps> = ({ className, keyValue, onClick }) => {
  return (
    <button
      className={`calcBtn ${className}`}
      onClick={() => onClick(keyValue)}
    >
      {keyValue}
    </button>
  );
}

export default memo(CalcKey);
