package net.p3pp3rf1y.sophisticatedcore.upgrades.cooking;

import net.p3pp3rf1y.sophisticatedcore.upgrades.UpgradeItemBase;
import net.p3pp3rf1y.sophisticatedcore.upgrades.UpgradeType;

public class AutoSmeltingUpgradeItem extends UpgradeItemBase<AutoCookingUpgradeWrapper.AutoSmeltingUpgradeWrapper> implements IAutoCookingUpgradeItem {
	public static final UpgradeType<AutoCookingUpgradeWrapper.AutoSmeltingUpgradeWrapper> TYPE = new UpgradeType<>(AutoCookingUpgradeWrapper.AutoSmeltingUpgradeWrapper::new);
	private final AutoCookingUpgradeConfig autoSmeltingUpgradeConfig;

	public AutoSmeltingUpgradeItem(AutoCookingUpgradeConfig autoSmeltingUpgradeConfig) {
		super();
		this.autoSmeltingUpgradeConfig = autoSmeltingUpgradeConfig;
	}

	@Override
	public UpgradeType<AutoCookingUpgradeWrapper.AutoSmeltingUpgradeWrapper> getType() {
		return TYPE;
	}

	@Override
	public AutoCookingUpgradeConfig getAutoCookingUpgradeConfig() {
		return autoSmeltingUpgradeConfig;
	}
}
