import React from "react";
interface Props {
  text: string;
  children: React.ReactNode;
}
const SelectionButton: React.FC<Props> = ({ text, children }) => {
  return (
    <button className="w-[22rem] h-[5rem] bg-buttonGrey rounded-full flex flex-row items-center px-6">
      <div className="flex justify-center items-center">{children}</div>
      <p className="text-3xl flex-1 justify-center">{text}</p>
    </button>
  );
};

export default SelectionButton;
