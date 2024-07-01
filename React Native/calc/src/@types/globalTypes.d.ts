export interface CalcKeyProps {
    className?: string;
    keyValue: string | number;
    onClick: (value: string | number) => void;
}

export type CalcOpType = { [key: string]: (a: number, b: number) => number }