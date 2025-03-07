import React from "react";
import { TextInput } from "@/app/components/home/buttons";
import classNames from "classnames";

interface Props {
  inputs: { text: string; type: string; options?: string[] }[];
  className?: string;
}

const InputSection: React.FC<Props> = React.memo(({ inputs, className }) => {
  return (
    <div className={classNames(className)}>
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
});

InputSection.displayName = "InputSection";

export default InputSection;
