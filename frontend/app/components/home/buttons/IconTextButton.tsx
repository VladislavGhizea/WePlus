import React from "react";
import classNames from "classnames";
interface Props {
  icon: React.ReactNode;
  text: string;
  onClick: () => void;
  className?: string;
}
const IconTextButton: React.FC<Props> = ({
  icon,
  text,
  onClick,
  className,
}) => {
  return (
    <button
      className={classNames(
        className,
        " flex flex-row items-center justify-evenly p-2 rounded-full w-52 mt-4"
      )}
      onClick={(e) => {
        e.preventDefault();
        onClick();
      }}
    >
      {icon}
      <div className="text-xl">{text}</div>
    </button>
  );
};

export default IconTextButton;
