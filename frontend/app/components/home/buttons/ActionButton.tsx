import React from "react";
interface Props {
  text: string;
  className?: string;
}
const ActionButton: React.FC<Props> = ({ text, className }) => {
  return (
    <button className={className + " relative"}>
      <div className="w-[9rem] h-[3.5rem] bg-white rounded-full">
        <div className="flex justify-center items-center h-full text-2xl">
          {text}
        </div>
      </div>
    </button>
  );
};
export default ActionButton;
