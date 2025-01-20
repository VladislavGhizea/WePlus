const Backdrop: React.FC<{ onClose: () => void }> = ({ onClose }) => (
  <div
    className="fixed z-[30] inset-0 bg-slate-500 bg-opacity-50 backdrop-blur-[2px]"
    onClick={onClose}
  ></div>
);
export default Backdrop;
