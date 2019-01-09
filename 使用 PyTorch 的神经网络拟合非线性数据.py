import torch
import torch.nn.functional as F
import matplotlib.pyplot as plt

x = torch.unsqueeze(torch.linspace(-1, 1, 100), dim=1)
y = x.pow(2) + 0.2 * torch.rand(x.size())


class Net(torch.nn.Module):
    def __init__(self, n_feature, n_hidden, n_output):
        super(Net, self).__init__()
        self.hidden = torch.nn.Linear(n_feature, n_hidden)
        self.predict = torch.nn.Linear(n_hidden, n_output)

    def forward(self, x):
        x = F.relu(self.hidden(x))
        x = self.predict(x)
        return x


net = Net(n_feature=1, n_hidden=10, n_output=1)
print(net)

# 传入 net 的所有参数, lr 是学习率的意思
optimizer = torch.optim.SGD(net.parameters(), lr=0.2)
# 预测值和真实值的误差计算公式（均方差）
loss_func = torch.nn.MSELoss()

for i in range(500):
    prediction = net(x)
    loss = loss_func(prediction, y)
    print('iter',i,'loss', loss.item())

    # 1、清空上一步的残余更新参数值
    optimizer.zero_grad()
    # 2、误差反向传播，计算参数更新值
    loss.backward()
    # 3、将参数更新值施加到 net 的 paramters 上
    optimizer.step()

    if i % 5 == 0:
        # plot and show learning process
        plt.cla()
        plt.scatter(x.data.numpy(), y.data.numpy())
        plt.plot(x.data.numpy(), prediction.data.numpy(), 'r-', lw=5)
        plt.text(-1.0, 1.2, 'iter:{}, Loss={:.6f} '.format(i, loss.data[0]), fontdict={'size': 20, 'color': 'red'})
        plt.pause(0.1)
