import React from "react";
interface Props {
  icon: React.ReactNode;
  onClick: () => void;
  className?: string;
}
const IconButton: React.FC<Props> = ({ icon, onClick, className }) => {
  return (
    <button
      className={className}
      onClick={(e) => {
        e.preventDefault();
        onClick();
      }}
    >
      {icon}
    </button>
  );
};

export default IconButton;
