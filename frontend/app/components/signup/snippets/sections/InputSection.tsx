import React from "react";
import { TextInput } from "@/app/components/home/buttons";

interface Props {
  inputs: { text: string; type: string; options?: string[] }[];
  className?: string;
}

const InputSection: React.FC<Props> = ({ inputs, className }) => {
  return (
    <div className={`${className}`}>
      {inputs.map((input, index) => (
        <TextInput
          classNameContainer="mt-4"
          key={index}
          text={input.text}
          type={input.type}
          options={input.options}
        />
      ))}
    </div>
  );
};

export default InputSection;
